package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.generated.ISBNService;
import com.example.generated.ISBNServiceSoapType;

@RestController
public class Controller {

	@GetMapping(value = "/test")
	public String metodo() {
		return "Hola, funciono bien";
	}

	@GetMapping(value = "/isvalidisbn13/{isbn}")
	public Boolean metodoSoap(@PathVariable("isbn") String isbn) {
		System.out.println(isbn);
		//instanciamos a la clase que implementa la interfaz creada por cfx
		//esa interfaz contiene todos los metodos disponibles en el wsdl
		ISBNServiceSoapType service = new ISBNService().getISBNServiceSoap();
		// isbn valido = "978-83-87121-23-5";
		return service.isValidISBN13(isbn);
	}

}
