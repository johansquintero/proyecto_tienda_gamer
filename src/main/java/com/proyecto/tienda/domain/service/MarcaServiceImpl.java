package com.proyecto.tienda.domain.service;

import com.proyecto.tienda.domain.pojo.MarcaPojo;
import com.proyecto.tienda.domain.repository.IMarcaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MarcaServiceImpl implements IMarcaService{

    /**
     * repositorio de la marca
     */
    private  final IMarcaRepository iMarcaRepository;

    /**
     * @return retorna una lista con todas la Marcas de los productos
     */
    @Transactional(readOnly = true)
    @Override
    public List<MarcaPojo> getAll() {
        return iMarcaRepository.getAll();
    }

    /**
     * Devuelve una marca a partir de su ID
     * @param id identificador de la marca
     * @return devuelve el optional casteando a un pojo la entidad
     */
    @Transactional(readOnly = true)
    @Override
    public Optional<MarcaPojo> getMarca(Long id) {
        return iMarcaRepository.getMarca(id);
    }

    /**
     *Guarda una nueva marca de producto
     * @param newMarca marca a insertar en la base de datos
     * @return retorna la marca creada
     */
    @Transactional
    @Override
    public MarcaPojo save(MarcaPojo newMarca) {
        return iMarcaRepository.save(newMarca);
    }

    /**
     *Elimina una marca de base de datos
     * @param id de la marca a eliminar
     * @return true si se elimina, false simo
     */

    @Transactional
    @Override
    public boolean delete(Long id) {
        try {
            iMarcaRepository.delete(id);
            return true;
        }catch (Exception e){
            return false;
        }

    }
}
