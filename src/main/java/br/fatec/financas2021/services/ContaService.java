package br.fatec.financas2021.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.fatec.financas2021.model.Conta;
import br.fatec.financas2021.repositories.ContaRepository;

@Service
public class ContaService implements ServiceInterface<Conta> {
	
	@Autowired
	private ContaRepository repository;
   
    public ContaService() {
    }

	@Override
	public Conta create(Conta obj) {
		repository.save(obj);
		return obj;
	}

	@Override
	public Conta FindById(Long id) {
		Optional<Conta> _conta = repository.findById(id);
		return _conta.orElse(null);
	}

	@Override
	public List<Conta> FindAll() {
		return repository.findAll();
	}
	
	@Override
	public boolean update(Conta obj) {
		if (repository.existsById(obj.getId())) {
			repository.save(obj);
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(Long id) {
		if (repository.existsById(id)) {
			repository.deleteById(id);
			return true;
		}
		return false;
	}
    
    
}
