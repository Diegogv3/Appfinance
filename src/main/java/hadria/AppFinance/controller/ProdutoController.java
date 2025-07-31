package hadria.AppFinance.controller;

import hadria.AppFinance.model.Produto;
import hadria.AppFinance.service.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping
    public List<Produto> getALl() { return produtoService.getAll();}

    @PostMapping
    public Produto create(@ModelAttribute Produto produto) {return produtoService.save(produto);}

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){produtoService.delete(id);}

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        Optional<Produto> produto = produtoService.getById(id);
        if (produto.isPresent()) {
            return ResponseEntity.ok(produto.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Produto não encontrado com o ID: " + id);
        }
    }

}
