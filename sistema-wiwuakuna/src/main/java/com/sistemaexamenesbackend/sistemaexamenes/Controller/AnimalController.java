package com.sistemaexamenesbackend.sistemaexamenes.Controller;

import com.google.gson.Gson;
import com.sistemaexamenesbackend.sistemaexamenes.Services.AnimalService;
import com.sistemaexamenesbackend.sistemaexamenes.Services.IUserAnimal;
import com.sistemaexamenesbackend.sistemaexamenes.Services.RolService;
import com.sistemaexamenesbackend.sistemaexamenes.Services.UserService;
import com.sistemaexamenesbackend.sistemaexamenes.config.JwtUtils;
import com.sistemaexamenesbackend.sistemaexamenes.entitys.*;
import com.sistemaexamenesbackend.sistemaexamenes.entitys.dto.AnimalDto;
import com.sistemaexamenesbackend.sistemaexamenes.entitys.dto.IncubacionDto;
import com.sistemaexamenesbackend.sistemaexamenes.repository.AnimalRespository;
import com.sistemaexamenesbackend.sistemaexamenes.repository.TypeAnimalRepository;
import com.sistemaexamenesbackend.sistemaexamenes.repository.UserAnimalRespository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;


import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("animal/v1")
@CrossOrigin("*")
public class AnimalController {

    @Autowired
    private UserService userService;

    @Autowired
    private AnimalService userAnimalSer;
    @Autowired
    private IUserAnimal iUserAnimal;

    @Autowired
    private TypeAnimalRepository typeAnimalRespository;

    @Autowired
    private Gson gson;
    @PostMapping(value="/save",  produces = MediaType.APPLICATION_JSON)
    @Transactional
    public ResponseEntity<?> GuardarUsuario(@RequestBody AnimalDto animalDto, @RequestParam("username") String username) throws Exception {
        User user=userService.ObtenerUsuario(username);
        Optional<typeAnimal> tanimal=typeAnimalRespository.findById(animalDto.getTipo());
        String jsonTemporal= gson.toJson(animalDto);
        Animal animal= Animal.builder()
                .name(animalDto.getName())
                .description(animalDto.getDescription())
                .countAnimal(animalDto.getCountAnimal())
                .dateRegistre(animalDto.getDateRegistre())
                .genero(animalDto.getGenero())
                .tipo(tanimal.get())
                .build();
        userAnimalSer.guardarAnimal(animal);
        UserAnimal userAnimal = new UserAnimal();
        userAnimal.setUsuario(user);
        userAnimal.setAnimal(animal);
        iUserAnimal.guardarRelacionUsuarioAnimal(userAnimal);
        return   ResponseEntity.status(HttpStatus.ACCEPTED).body("ok");
    }
    @PostMapping("/incubacion")
    public void incubacion(@RequestBody IncubacionDto incubacionDto)
    {
        userAnimalSer.state(incubacionDto);
    }
    @GetMapping("/List")
    public List<Animal> listAnimal()  {
        List<Animal>  list= userAnimalSer.ListAnimal();
        return list;
    }
    @GetMapping("/search")
    public List<Animal>  listAnimalByName( @RequestParam("name") String name) {

        List<Animal>  list= userAnimalSer.ListPorTipoAnimal(name);

        return list;
    }

    @GetMapping("/animalbyUser")
    public Set<AnimalDto>  mylistAnimal( @RequestParam("username") String username) {
        User user=userService.ObtenerUsuario(username);
        Set<Animal>  list= iUserAnimal.buscarAnimalesDelUsuario(user);
        Set<AnimalDto> dtos = new HashSet<>();
        for (Animal entidad : list) {
            dtos.add(AnimalDto.builder()
                            .id(entidad.getId())
                            .incubationState(entidad.getIncubation_state())
                            .incubationDescription(entidad.getIncubationDescription())
                             .state(entidad.getState())
                            .name(entidad.getName())
                            .description(entidad.getDescription())
                            .strTipo(entidad.getTipo().getTypeName())
                            .genero(entidad.getGenero())
                            .dateRegistre(entidad.getDateRegistre())
                    .countAnimal(entidad.getCountAnimal())
                     .build());
        }
        return dtos;

    }
    @GetMapping("/search/categoria")
    public List<typeAnimal>  mylistAnimalCategoria( ) {

        List<typeAnimal>  list= typeAnimalRespository.findAll();
        return list;
    }
}
