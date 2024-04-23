package edu.unicauca.SivriBackendApp.common.email.service;

import edu.unicauca.SivriBackendApp.common.email.dto.MetaData;
import edu.unicauca.SivriBackendApp.common.email.dto.SendRequest;
import edu.unicauca.SivriBackendApp.common.email.entity.Templates;
import edu.unicauca.SivriBackendApp.common.email.repository.TemplateRepository;
import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.handler.RespuestaHandler;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;
import org.springframework.web.server.NotAcceptableStatusException;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@AllArgsConstructor
public class SendMessageService {

	private final JavaMailSender mailSender;
	private final TemplateRepository templateRepository;
	private final ResourceLoader resourceLoader;

	private static final String FROM = "Confety.Studios";

	private Optional<String> cargarPlantilla(String nombreArchivo) {
		try {
			Resource resource = resourceLoader.getResource("classpath:/templates/" + nombreArchivo);
			InputStream inputStream = resource.getInputStream();
			String contenido = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);

			return Optional.of(contenido);
		} catch (IOException e) {
			// Manejar la excepción apropiadamente
			e.printStackTrace();
			return Optional.empty();
		}
	}

	public Respuesta sendMessage(SendRequest sendRequest) {
		try {
			if (validarCorreo(sendRequest.getTo())) {
				String messageContent = buildMessage(sendRequest);
				MimeMessage message = mailSender.createMimeMessage();
				MimeMessageHelper helper;
				helper = new MimeMessageHelper(message, true);
				helper.setFrom(FROM);
				helper.setTo(sendRequest.getTo());
				helper.setSubject(sendRequest.getSubject());
				helper.setText(messageContent, true);
				mailSender.send(message);
			}else {
				throw new ReglaDeNegocioException("bad.to.recipient1");
			}

		} catch (NotAcceptableStatusException e1) {
			throw new ReglaDeNegocioException("bad.metadata", List.of(e1));
		} catch (MessagingException e) {
			throw new ReglaDeNegocioException("bad.to.recipient3");
		}
		return new RespuestaHandler<>(200, "ok.mail", List.of(sendRequest.getTo()), "",true).getRespuesta();
	}

	private String buildMessage(SendRequest sendRequest) {
		try {
			Optional<Templates> template = templateRepository.findById(sendRequest.getTemplate());

			if (template.isPresent()) {

				Optional<String> templateContent = cargarPlantilla(template.get().getNombreTemplate());
				if (templateContent.isEmpty()){
					throw new NotAcceptableStatusException("No se encontro el cuerpo del Template con Id "+ sendRequest.getTemplate());
				}
				String finalMessage = templateContent.get();

				//Set MetadataService
				for (MetaData meta : sendRequest.getMetaData()) {
					if(template.get().getVars().contains(meta.getKey())) {
						finalMessage = finalMessage.replace("$[{" + meta.getKey() + "}]", meta.getValue());
					}else {
						throw new NotAcceptableStatusException("MetaData incompleta debe contener -> "+ template.get().getVars());
					}
				}
				
				return finalMessage;
			} else {
				throw new NotAcceptableStatusException("Template con Id "+ sendRequest.getTemplate() + " no existe.");
			}
		}catch(NotAcceptableStatusException no) {
			throw no;
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private Boolean validarCorreo(String email) {
		Pattern pattern = Pattern
				.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		Matcher mather = pattern.matcher(email);
		return mather.find();
	}
}
