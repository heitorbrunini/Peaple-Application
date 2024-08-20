package com.form.peaple;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

@SpringBootApplication
public class PeapleApplication extends Application {

	private ConfigurableApplicationContext springContext;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void init() throws Exception {
		SpringApplicationBuilder builder = new SpringApplicationBuilder(PeapleApplication.class);
		springContext = builder.run(getParameters().getRaw().toArray(new String[0]));
	}

	// Application Interface method implementation
	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/main.fxml"));
		fxmlLoader.setControllerFactory(springContext::getBean);

		// Define a cena (Scene) com o layout carregado
		primaryStage.setScene(new Scene(fxmlLoader.load()));
		primaryStage.setTitle("Cadastro de Pessoas");
		primaryStage.show();

	}

	@Override
	public void stop() throws Exception {
		springContext.close();
	}

}