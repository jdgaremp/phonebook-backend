package SpringBootApplication.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import SpringBootApplication.Repository.PersonRepository;
import SpringBootApplication.model.Person;

@Service
public class PersonService implements PersonRepository {

	@Autowired
	PersonRepository personRepository;

	@Override
	public <S extends Person> List<S> saveAll(Iterable<S> entities) {
		return personRepository.saveAll(entities);
	}

	@Override
	public List<Person> findAll() {
		return personRepository.findAll();
	}

	@Override
	public List<Person> findAll(Sort sort) {
		return personRepository.findAll(sort);
	}

	@Override
	public <S extends Person> S insert(S entity) {
		return personRepository.insert(entity);
	}

	@Override
	public <S extends Person> List<S> insert(Iterable<S> entities) {
		return personRepository.insert(entities);
	}

	@Override
	public <S extends Person> List<S> findAll(Example<S> example) {
		return personRepository.findAll(example);
	}

	@Override
	public <S extends Person> List<S> findAll(Example<S> example, Sort sort) {
		return personRepository.findAll(example, sort);
	}

	@Override
	public Page<Person> findAll(Pageable pageable) {
		return personRepository.findAll(pageable);
	}

	@Override
	public <S extends Person> S save(S entity) {
		return personRepository.save(entity);
	}

	@Override
	public Optional<Person> findById(String id) {
		return personRepository.findById(id);
	}

	public Person findByIdString(String id) {
		Person person = null;
		for (Person p : findAll()) {
			if (id != null && !id.isEmpty()
					&& p.getId().toLowerCase().contains(id.toLowerCase())) {
				person=p;
			}
		}
		return person;
	}

	@Override
	public boolean existsById(String id) {
		return personRepository.existsById(id);
	}

	@Override
	public Iterable<Person> findAllById(Iterable<String> ids) {
		return personRepository.findAllById(ids);
	}

	@Override
	public long count() {
		return personRepository.count();
	}

	@Override
	public void deleteById(String id) {
		personRepository.deleteById(id);
	}

	@Override
	public void delete(Person entity) {
		personRepository.delete(entity);

	}

	@Override
	public void deleteAll(Iterable<? extends Person> entities) {
		personRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		personRepository.deleteAll();
	}

	@Override
	public <S extends Person> Optional<S> findOne(Example<S> example) {
		return personRepository.findOne(example);
	}

	@Override
	public <S extends Person> Page<S> findAll(Example<S> example, Pageable pageable) {
		return personRepository.findAll(example, pageable);
	}

	@Override
	public <S extends Person> long count(Example<S> example) {
		return personRepository.count(example);
	}

	@Override
	public <S extends Person> boolean exists(Example<S> example) {
		return personRepository.exists(example);
	}

	@Override
	public List<Person> findByFirstName(String firstName) {
		List<Person> persons = new ArrayList<>();
		String[] firstNameSplited = firstName.split(" ");
		for (int i = 0; i < firstNameSplited.length; i++) {
			for (Person person : findAll()) {
				if (firstNameSplited[0] != null && !firstNameSplited[0].isEmpty()
						&& person.getFirstName().toLowerCase().contains(firstNameSplited[0].toLowerCase())) {
					persons.add(person);
				}
			}
		}
		return persons;
	}

	@Override
	public List<Person> findByLastName(String lastName) {
		List<Person> persons = new ArrayList<>();
		String[] lastNameSplited = lastName.split(" ");
		for (int i = 0; i < lastNameSplited.length; i++) {
			for (Person person : findAll()) {
				if (!lastNameSplited[0].isEmpty()
						&& person.getLastName().toLowerCase().contains(lastNameSplited[0].toLowerCase())) {
					persons.add(person);
				}
			}
		}
		return persons;
	}

	@Override
	public List<Person> findByPhoneNumber(String phoneNumber) {
		List<Person> persons = new ArrayList<>();
		String[] phoneNumberSplited = phoneNumber.split(" ");
		for (int i = 0; i < phoneNumberSplited.length; i++) {
			for (Person person : findAll()) {
				if (phoneNumberSplited[0] != null && !phoneNumberSplited[0].isEmpty()
						&& person.getPhoneNumber().toLowerCase().contains(phoneNumberSplited[0].toLowerCase())) {
					persons.add(person);
				}
			}
		}
		return persons;
	}

	public void find(String firstName, String lastName, String phoneNumber) {

	}

}
