package com.projetojpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetojpa.entities.Agenda;
import com.projetojpa.repository.AgendaRepository;


@Service
public class AgendaService {
	private final AgendaRepository agendaRepository;

	@Autowired
	public AgendaService(AgendaRepository agendaRepository) {
		this.agendaRepository = agendaRepository;
	}
	//Método para buscar todos os produtos
	public List<Agenda> buscaTodosAgenda() {
		return agendaRepository.findAll();
	}
	//Método para buscar todos os produtos
		public Agenda buscaAgendaId(Long id) {
			Optional <Agenda> agenda = agendaRepository.findById(id);
			return agenda.orElse(null);
		}
		//Método para salvar os produtos
		public Agenda salvaAgenda(Agenda agenda) {
			return agendaRepository.save(agenda);
		}
		public Agenda alterarAgenda(Long id, Agenda alterarAgenda) {
			Optional <Agenda> existeAgenda = agendaRepository.findById(id);
			if (existeAgenda.isPresent()) {
				alterarAgenda.setId(id);
				return agendaRepository.save(alterarAgenda);
			}
			return null;
		}
		//Método para excluir dados
		public boolean apagarAgenda(Long id) {
			Optional <Agenda> existeAgenda = agendaRepository.findById(id);
			if (existeAgenda.isPresent()) {
				agendaRepository.deleteById(id);
				return true;
			}
			return false;
		}
}
