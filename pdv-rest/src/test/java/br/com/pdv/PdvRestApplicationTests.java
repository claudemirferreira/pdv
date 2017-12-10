package br.com.pdv;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.pdv.enumerated.TipoMovimentacaoEnum;
import br.com.pdv.enumerated.UnidadeMedidaEnum;
import br.com.pdv.model.dao.MovimentacaoDAO;
import br.com.pdv.model.dao.MovimentacaoProdutoDAO;
import br.com.pdv.model.dao.ProdutoDAO;
import br.com.pdv.model.entity.Movimentacao;
import br.com.pdv.model.entity.MovimentacaoProduto;
import br.com.pdv.model.entity.Produto;

@RunWith(SpringRunner.class)
@SpringBootTest
@Profile("test")
public class PdvRestApplicationTests {

	@Autowired
	ProdutoDAO produtoDAO;

	@Autowired
	MovimentacaoDAO movimentacaoDAO;

	@Autowired
	MovimentacaoProdutoDAO movimentacaoProdutoDAO;

	@Test
	public void saveMovimentacaoProduto() {
		Produto p = new Produto("claudemir", "123455", new BigDecimal(22), new BigDecimal(22), (long) 0, UnidadeMedidaEnum.UNIDADE);
		produtoDAO.save(p);
		
		Movimentacao m = new Movimentacao(LocalDate.now(), "2222222", "iiiiiii", TipoMovimentacaoEnum.ENTRADA);
		movimentacaoDAO.save(m);
		
		MovimentacaoProduto mp = new MovimentacaoProduto(p, 100l, m);

		movimentacaoProdutoDAO.save(mp);
	}

}