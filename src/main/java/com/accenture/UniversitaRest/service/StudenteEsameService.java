package com.accenture.UniversitaRest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.UniversitaRest.dto.EsameDto;
import com.accenture.UniversitaRest.dto.StudenteEsameDto;
import com.accenture.UniversitaRest.model.Esame;
import com.accenture.UniversitaRest.model.Studente;
import com.accenture.UniversitaRest.model.StudenteEsame;
import com.accenture.UniversitaRest.repository.EsameRepository;
import com.accenture.UniversitaRest.repository.StudenteEsameRepository;

@Service
public class StudenteEsameService {

    @Autowired
    private StudenteEsameRepository studenteEsameRepository;

    @Autowired
    private StudenteService studenteService;

    @Autowired
    private EsameService esameService;

    public StudenteEsame save(StudenteEsameDto studenteEsameDto){
        //questo metodo converte il dto nell'entità che andrà salvata nel db
        StudenteEsame studenteEsame = dtoToEntity(studenteEsameDto);

        return studenteEsameRepository.save(studenteEsame);
    }

    public StudenteEsame update(Integer id, StudenteEsameDto studenteEsameDto){
        StudenteEsame studenteEsameDaAggiornare = studenteEsameRepository.findById(id).get();

        StudenteEsame studenteEsame = dtoToEntity(studenteEsameDto);

        studenteEsameDaAggiornare.setDataEsame(studenteEsame.getDataEsame());
        studenteEsameDaAggiornare.setVoto(studenteEsame.getVoto());
        studenteEsameDaAggiornare.setStudente(studenteEsame.getStudente());
        studenteEsameDaAggiornare.setEsame(studenteEsame.getEsame());
       

        return studenteEsameRepository.save(studenteEsameDaAggiornare);
    }

    public void delete(Integer id){
        
        studenteEsameRepository.deleteById(id);
    }

    public StudenteEsame getById(Integer id){
        return studenteEsameRepository.findById(id).get();
    }

    public List<StudenteEsame> getAll(){
        return studenteEsameRepository.findAll();
    }

    private StudenteEsame dtoToEntity(StudenteEsameDto studenteEsameDto){
        StudenteEsame studenteEsame = new StudenteEsame();

        studenteEsame.setDataEsame(studenteEsameDto.getDataEsame());
        studenteEsame.setVoto(studenteEsameDto.getVoto());
        //verifico se l'id dello studente è presente nel db utilizzando il service dello studente
        //se c'è lo inserisco nell'oggetto studenteEsame, altrimenti va in eccezione
        Studente studente = studenteService.getByMatricola(studenteEsameDto.getStudente_id());
        
        studenteEsame.setStudente(studente);
        //verifico se l'id dell'esame' è presente nel db utilizzando il service dell'esame
        //se c'è lo inserisco nell'oggetto studenteEsame, altrimenti va in eccezione
        Esame esame = esameService.getById(studenteEsameDto.getEsame_id());

        studenteEsame.setEsame(esame);
        
        return studenteEsame;
    }
    
}
