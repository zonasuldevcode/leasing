package br.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.modelo.Vendedor;

@Repository
public interface  VendedorRepository  extends JpaRepository<Vendedor, Long>{

}
