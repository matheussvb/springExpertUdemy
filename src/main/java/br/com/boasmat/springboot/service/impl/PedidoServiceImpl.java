package br.com.boasmat.springboot.service.impl;

import br.com.boasmat.springboot.domain.entity.Cliente;
import br.com.boasmat.springboot.domain.entity.ItemPedido;
import br.com.boasmat.springboot.domain.entity.Pedido;
import br.com.boasmat.springboot.domain.entity.Produto;
import br.com.boasmat.springboot.domain.repository.ClienteRepository;
import br.com.boasmat.springboot.domain.repository.ItensPedidoRepository;
import br.com.boasmat.springboot.domain.repository.PedidosRepository;
import br.com.boasmat.springboot.domain.repository.ProdutosRepository;
import br.com.boasmat.springboot.exception.RegraNegocioException;
import br.com.boasmat.springboot.res.dto.ItemPedidoDTO;
import br.com.boasmat.springboot.res.dto.PedidoDTO;
import br.com.boasmat.springboot.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PedidoServiceImpl implements PedidoService {

    //p/ usar anotação do lombok
    private final PedidosRepository pedidosRepository;
    private final ProdutosRepository produtosRepository;
    private final ClienteRepository clienteRespository;
    private final ItensPedidoRepository itensPedidoRepository;


    @Override
    @Transactional
    public Pedido salvar(PedidoDTO dto) {
        Integer idCliente = dto.getCliente();
        Cliente cliente = clienteRespository.findById(idCliente)
                .orElseThrow(() ->
                        new RegraNegocioException("Código de cliente invalido"));


        Pedido pedido = new Pedido();
        pedido.setTotal(dto.getTotal());
        pedido.setDataPedido(LocalDate.now());
        pedido.setCliente(cliente);

        List<ItemPedido> itemPedidos = converteIteams(pedido, dto.getItensPedido());
        pedidosRepository.save(pedido);
        itensPedidoRepository.saveAll(itemPedidos);
        pedido.setItens(itemPedidos);


        return pedido;
    }

    @Override
    public Optional<Pedido> obterPedidoCompleto(Integer id) {
        return pedidosRepository.findByIdFetchItens(id);
    }


    private List<ItemPedido> converteIteams(Pedido pedido, List<ItemPedidoDTO> itensPedido) {
        if (itensPedido.isEmpty()) {
            throw new RegraNegocioException("Não é possível realizar um pedido sem ");
        }

        return itensPedido.stream()
                .map(dto -> {
                    Integer idProduto = dto.getProduto();
                    Produto produto = this.produtosRepository.findById(idProduto)
                            .orElseThrow(() ->
                                    new RegraNegocioException("Códido de produto inválido: " +
                                            idProduto));

                    ItemPedido itemPedido = new ItemPedido();
                    itemPedido.setQuantidade(dto.getQuantidade());
                    itemPedido.setPedido(pedido);
                    itemPedido.setProduto(produto);
                    return itemPedido;
                }).collect(Collectors.toList());


    }
}
