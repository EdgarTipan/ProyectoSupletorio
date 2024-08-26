package ec.edu.uce.ProyectoRecuperacion;

import ec.edu.uce.ProyectoRecuperacion.view.TareaApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProyectoRecuperacionApplication implements CommandLineRunner {

	private final TareaApp tareaApp;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoRecuperacionApplication.class, args);
	}

	@Autowired
	public ProyectoRecuperacionApplication(TareaApp tareaApp) {
		this.tareaApp = tareaApp;
	}

	@Override
	public void run(String... args) throws Exception {
		tareaApp.run();
	}
}
