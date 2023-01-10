package br.com.service;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;
import java.util.stream.BaseStream;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.modelo.Aluguel;
import br.com.modelo.Cliente;
import br.com.modelo.Veiculo;
import br.com.modelo.Vendedor;
import br.com.repository.AluguelRepository;
import br.com.repository.ClienteRepository;
import br.com.repository.VeiculoRepository;
import br.com.repository.VendedorRepository;

@Service
public class AluguelService {


	@Autowired
	private AluguelRepository aluguelRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private VendedorRepository vendedorRepository;
	@Autowired
	private VeiculoRepository veiculoRepository;
	
	
	public Aluguel cadastrar( Long idCliente, Long idVendedor, Long idVeiculo) {
		
		    Aluguel aluguel = new Aluguel();
		    
			
			aluguel.setCliente(clienteRepository.findById(idCliente).get());
			aluguel.setVeiculo(veiculoRepository.findById(idVeiculo).get());
			aluguel.setVendedor(vendedorRepository.findById(idVendedor).get());

			
			BaseStream<LocalDate,Stream<LocalDate>> period = aluguel.getDataRetirada().datesUntil(aluguel.getDataDevolucao());
			aluguel.setTotal((BigDecimal) period);
			
			
		 
			return aluguelRepository.save(aluguel);

			
	}
	

}