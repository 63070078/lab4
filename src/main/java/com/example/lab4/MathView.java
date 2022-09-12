package com.example.lab4;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

@Route(value = "index1")
public class MathView extends VerticalLayout {
    private Button btnPlus, btnMinus, btnMulti, btnDivide, btnMod, btnMax;
    private TextField txt1, txt2, txt3;
    private Label label1;
    private HorizontalLayout h1;
    public MathView() {
        h1 = new HorizontalLayout();
        txt1 = new TextField();
        txt1.setLabel("Number1");

        txt2 = new TextField();
        txt2.setLabel("Number2");

        label1 = new Label("Operator");

        btnPlus = new Button("+");
        btnMinus = new Button("-");
        btnMulti = new Button("x");
        btnDivide = new Button("/");
        btnMod = new Button("Mod");
        btnMax = new Button("Max");

        txt3 = new TextField();
        txt3.setLabel("Answer");

        h1.add(btnPlus, btnMinus, btnMulti, btnDivide, btnMod, btnMax);
        add(txt1, txt2, label1, h1, txt3);

        btnPlus.addClickListener(event ->{
            double num1 = Double.parseDouble(txt1.getValue());
            double num2 = Double.parseDouble(txt2.getValue());

            String out = WebClient.create()
                    .get()
                    .uri("http://localhost:8080/plus/"+num1+"/"+num2)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();

            txt3.setValue(out);
        });
        btnMinus.addClickListener(event ->{
            double num1 = Double.parseDouble(txt1.getValue());
            double num2 = Double.parseDouble(txt2.getValue());

            String out = WebClient.create()
                    .get()
                    .uri("http://localhost:8080/minus/"+num1+"/"+num2)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();

            txt3.setValue(out);
        });
        btnMulti.addClickListener(event ->{
            double num1 = Double.parseDouble(txt1.getValue());
            double num2 = Double.parseDouble(txt2.getValue());

            String out = WebClient.create()
                    .get()
                    .uri("http://localhost:8080/multi/"+num1+"/"+num2)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();

            txt3.setValue(out);
        });
        btnDivide.addClickListener(event ->{
            double num1 = Double.parseDouble(txt1.getValue());
            double num2 = Double.parseDouble(txt2.getValue());

            String out = WebClient.create()
                    .get()
                    .uri("http://localhost:8080/divide/"+num1+"/"+num2)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();

            txt3.setValue(out);
        });
        btnMod.addClickListener(event ->{
            double num1 = Double.parseDouble(txt1.getValue());
            double num2 = Double.parseDouble(txt2.getValue());

            String out = WebClient.create()
                    .get()
                    .uri("http://localhost:8080/mod/"+num1+"/"+num2)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();

            txt3.setValue(out);
        });
        btnMax.addClickListener(event ->{
            MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
            formData.add("n1", txt1.getValue());
            formData.add("n2", txt2.getValue());

            String out = WebClient.create()
                    .post()
                    .uri("http://localhost:8080/max")
                    .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                    .body(BodyInserters.fromFormData(formData))
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();

            txt3.setValue(out);
        });
    }
}
