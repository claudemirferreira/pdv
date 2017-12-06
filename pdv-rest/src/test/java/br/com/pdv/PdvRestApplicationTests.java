package br.com.pdv;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.pdv.enumerated.UnidadeMedidaEnum;
import br.com.pdv.model.dao.ProdutoDAO;
import br.com.pdv.model.entity.Produto;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PdvRestApplicationTests {

	@Autowired
	ProdutoDAO repository;

	@Test
	public void contextLoads() {
		Produto p = new Produto("claudemir", "123455", new BigDecimal(22), new BigDecimal(22), (long) 0,
				UnidadeMedidaEnum.UNIDADE);
		// p.setId((Long) null);
		repository.save(p);
	}

}
