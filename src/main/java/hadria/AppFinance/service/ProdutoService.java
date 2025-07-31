package hadria.AppFinance.service;

import hadria.AppFinance.model.Produto;
import hadria.AppFinance.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.LongAdder;

@Service
public class ProdutoService {
    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    //LISTAR
    public List<Produto> getAll() {return produtoRepository.findAll();}
    //CRIAR
    public Produto save(Produto produto) {return produtoRepository.save(produto);}
    //DELETAR
    public void delete(Long id){produtoRepository.deleteById(id);}

    public Optional<Produto> getById(Long id){return produtoRepository.findById(id);}
}
