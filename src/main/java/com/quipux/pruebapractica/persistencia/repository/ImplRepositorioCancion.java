package com.quipux.pruebapractica.persistencia.repository;

import com.quipux.pruebapractica.dominio.core.Cancion;
import com.quipux.pruebapractica.dominio.dto.CancionDto;
import com.quipux.pruebapractica.dominio.repositorio.RepositorioCancion;
import com.quipux.pruebapractica.persistencia.crud.CrudCancion;
import com.quipux.pruebapractica.persistencia.entity.CancionEntity;
import com.quipux.pruebapractica.persistencia.mapper.MapeadorCancion;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Repository
public class ImplRepositorioCancion implements RepositorioCancion {
    private final CrudCancion crudCancion;
    private final MapeadorCancion mapeadorCancion;

    public ImplRepositorioCancion(CrudCancion crudCancion, MapeadorCancion mapeadorCancion) {
        this.crudCancion = crudCancion;
        this.mapeadorCancion = mapeadorCancion;
    }

    @Override
    public List<CancionDto> obtenerCancionesPorIdLista(Integer idLista) {
        return mapeadorCancion.convertiAListaCancionesDto(crudCancion.obtenerCancionesPorLista(idLista));
    }

    @Override
    public List<CancionDto> guardarCanciones(List<Cancion> canciones) {
        return mapeadorCancion.convertiAListaCancionesDto((List<CancionEntity>) crudCancion.saveAll(mapeadorCancion.convertirAListaEntity(canciones)));
    }

    @Override
    public void eliminarCancionPorId(Integer id) {
        crudCancion.deleteById(id);
    }
}
