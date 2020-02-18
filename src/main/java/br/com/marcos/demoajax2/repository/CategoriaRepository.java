package br.com.marcos.demoajax2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.marcos.demoajax2.domain.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

}
