package com.projetojpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetojpa.entities.Ligacao;
import com.projetojpa.repository.LigacaoRepository;



@Service
public class LigacaoService {
	private final LigacaoRepository ligacaoRepository;

	@Autowired
	public LigacaoService(LigacaoRepository ligacaoRepository) {
		this.ligacaoRepository = ligacaoRepository;
	}
	//Método para buscar todos os produtos
	public List<Ligacao> buscaTodosLigacao() {
		return ligacaoRepository.findAll();
	}
	//Método para buscar todos os produtos
		public Ligacao buscaLigacaoId(Long id) {
			Optional <Ligacao> ligacao = ligacaoRepository.findById(id);
			return ligacao.orElse(null);
		}
		//Método para salvar os produtos
				public Ligacao salvaLigacao(Ligacao ligacao) {
					return ligacaoRepository.save(ligacao);
				}
				public Ligacao alterarLigacao(Long id, Ligacao alterarLigacao) {
					Optional <Ligacao> existeLigacao = ligacaoRepository.findById(id);
					if (existeLigacao.isPresent()) {
						alterarLigacao.setId(id);
						return ligacaoRepository.save(alterarLigacao);
					}
					return null;
				}
				//Método para excluir dados
				public boolean apagarLigacao(Long id) {
					Optional <Ligacao> existeLigacao = ligacaoRepository.findById(id);
					if (existeLigacao.isPresent()) {
						ligacaoRepository.deleteById(id);
						return true;
					}
					return false;
				}
}
