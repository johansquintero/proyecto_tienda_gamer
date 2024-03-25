package com.proyecto.tienda.persistance.repository;

import com.proyecto.tienda.domain.dto.cart.CartRequestDto;
import com.proyecto.tienda.domain.dto.cart.CartResponseDto;
import com.proyecto.tienda.domain.repository.ICartRepository;
import com.proyecto.tienda.persistance.crud.ICartCrudRepository;
import com.proyecto.tienda.persistance.entity.CartEntity;
import com.proyecto.tienda.persistance.mapper.cart.ICartRequestMapper;
import com.proyecto.tienda.persistance.mapper.cart.ICartResponseMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class CartRepositoryImpl implements ICartRepository {
    private final ICartCrudRepository iCartCrudRepository;
    private final ICartRequestMapper iCartRequestMapper;
    private final ICartResponseMapper iCartResponseMapper;
    /**
     * @param id
     * @return
     */
    @Override
    public Optional<CartResponseDto> getCartById(Long id) {
        var x = this.iCartCrudRepository.findById(id).map(this.iCartResponseMapper::toCartResponseDto);
        System.out.println("LLEGO"+x.get().getCustomerId());
        return x;
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Optional<CartResponseDto> getCartByCustomerId(Long id) {
        return this.iCartCrudRepository.findByCustomerId(id).map(this.iCartResponseMapper::toCartResponseDto);
    }

    /**
     * @param cartRequestDto
     * @return
     */
    @Override
    public Optional<CartResponseDto> save(CartRequestDto cartRequestDto) {
        CartEntity cartEntity = this.iCartRequestMapper.toCartEntity(cartRequestDto);
        CartEntity saved = this.iCartCrudRepository.save(cartEntity);
        CartResponseDto cartResponseDto = this.iCartResponseMapper.toCartResponseDto(saved);
        return Optional.of(cartResponseDto);
    }

    /**
     * @param id
     * @return
     */
    @Override
    public void delete(Long id) {
        this.iCartCrudRepository.deleteById(id);
    }
}
