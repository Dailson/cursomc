package com.dailson.cursomc;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dailson.cursomc.domain.Address;
import com.dailson.cursomc.domain.Category;
import com.dailson.cursomc.domain.City;
import com.dailson.cursomc.domain.Client;
import com.dailson.cursomc.domain.Demand;
import com.dailson.cursomc.domain.ItemDemand;
import com.dailson.cursomc.domain.Payment;
import com.dailson.cursomc.domain.PaymentBoleto;
import com.dailson.cursomc.domain.PaymentCard;
import com.dailson.cursomc.domain.Product;
import com.dailson.cursomc.domain.State;
import com.dailson.cursomc.domain.enums.ClientType;
import com.dailson.cursomc.domain.enums.PaymentStatus;
import com.dailson.cursomc.repositories.AddressRepository;
import com.dailson.cursomc.repositories.CategoryRepository;
import com.dailson.cursomc.repositories.CityRepository;
import com.dailson.cursomc.repositories.ClientRepository;
import com.dailson.cursomc.repositories.DemandRepository;
import com.dailson.cursomc.repositories.ItemDemanRepository;
import com.dailson.cursomc.repositories.PaymentRepository;
import com.dailson.cursomc.repositories.ProductRepository;
import com.dailson.cursomc.repositories.StateRepository;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CityRepository cityRepository;
	
	@Autowired
	private StateRepository stateRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	@Autowired
	private DemandRepository demandRepository;
	
	@Autowired
	private ItemDemanRepository itemDemanRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Category cat1 = new Category(null, "Informática");
		Category cat2 = new Category(null, "Escritório");
		Category cat3 = new Category(null, "Cama mesa e banho");
		Category cat4 = new Category(null, "Eletrônicos");
		Category cat5 = new Category(null, "Jardinagem");
		Category cat6 = new Category(null, "Decoração");
		Category cat7 = new Category(null, "Perfumaria");
		
		
		Product p1 = new Product(null, "Computador", 2000.00);
		Product p2 = new Product(null, "Impressora", 800.00);
		Product p3 = new Product(null, "Mouse", 80.00);
		
		cat1.getProducts().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProducts().addAll(Arrays.asList(p2));
		
		p1.getCategories().addAll(Arrays.asList(cat1));
		p2.getCategories().addAll(Arrays.asList(cat1, cat2));
		p3.getCategories().addAll(Arrays.asList(cat1));
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7));
		productRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		State est1 = new State(null, "Minas Gerais");
		State est2 = new State(null, "São Paulo");
		
		City c1 = new City(null, "Uberlância", est1);
		City c2 = new City(null, "São Paulo", est2);
		City c3  = new City(null, "Capinas", est2);
		
		est1.getCities().addAll(Arrays.asList(c1));
		est2.getCities().addAll(Arrays.asList(c2, c3));
		
		
		stateRepository.saveAll(Arrays.asList(est1, est2));
		cityRepository.saveAll(Arrays.asList(c1, c2, c3));

		Client cli1 = new Client(null, "Maria", "maria@gmail.com", "12345678901", ClientType.NATURAL_PERSON);
		cli1.getTelephones().addAll(Arrays.asList("000111","000222"));
		
		Address add1 = new Address(null, "Rua Flores", "300", "Apto 303", "Jardim","3822084", cli1, c1);
		Address add2 = new Address(null, "Avenida Matos", "105", "sala 800", "Centro","38777012", cli1, c2);
		
		cli1.getAddresses().addAll(Arrays.asList(add1, add2));
		
		clientRepository.saveAll(Arrays.asList(cli1));
		addressRepository.saveAll(Arrays.asList(add1, add2));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Demand dm1 = new Demand(null, sdf.parse("06/03/2021 16:52"),cli1, add1);
		Demand dm2 = new Demand(null, sdf.parse("10/02/2021 10:0"),cli1, add2);
		
		Payment paym1 = new PaymentCard(null, PaymentStatus.SETTLED , dm1, 6);
		dm1.setPayment(paym1);
		
		Payment paym2 = new PaymentBoleto(null, PaymentStatus.PENDING, dm2, sdf.parse("11/01/2020 10:59"), null);
		dm2.setPayment(paym2);
		
		cli1.getDemands().addAll(Arrays.asList(dm1, dm2));
		
		demandRepository.saveAll(Arrays.asList(dm1, dm2));
		paymentRepository.saveAll(Arrays.asList(paym1, paym2));
		
		ItemDemand id1 = new ItemDemand(dm1, p1, 0.0, 1, 2000.00);
		ItemDemand id2 = new ItemDemand(dm1, p3, 0.0, 2, 80.00);
		ItemDemand id3 = new ItemDemand(dm2, p2, 100.00, 1, 800.00);
		
		dm1.getItens().addAll(Arrays.asList(id1, id2));
		dm2.getItens().addAll(Arrays.asList(id3));
		
		p1.getItens().addAll(Arrays.asList(id1));
		p2.getItens().addAll(Arrays.asList(id3));
		p3.getItens().addAll(Arrays.asList(id2));
		
		itemDemanRepository.saveAll(Arrays.asList(id1, id2, id3));
	}

}
