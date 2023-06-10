package com.cip.demo.CIP;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@SpringBootApplication
public class DemoCipApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoCipApplication.class, args);
		 final IPollRepository pollRepository = new IPollRepository() {
			 @Override
			 public Poll save(Poll poll) {
				 return null;
			 }

			 @Override
			 public List<Poll> findAll() {
				 return null;
			 }

			 @Override
			 public Optional<Poll> findById(Long id) {
				 return Optional.empty();
			 }

			 @Override
			 public void deleteById(Long id) {

			 }

			 @Override
			 public void flush() {

			 }

			 @Override
			 public <S extends Poll> S saveAndFlush(S entity) {
				 return null;
			 }

			 @Override
			 public <S extends Poll> List<S> saveAllAndFlush(Iterable<S> entities) {
				 return null;
			 }

			 @Override
			 public void deleteAllInBatch(Iterable<Poll> entities) {

			 }

			 @Override
			 public void deleteAllByIdInBatch(Iterable<Long> longs) {

			 }

			 @Override
			 public void deleteAllInBatch() {

			 }

			 @Override
			 public Poll getOne(Long aLong) {
				 return null;
			 }

			 @Override
			 public Poll getById(Long aLong) {
				 return null;
			 }

			 @Override
			 public Poll getReferenceById(Long aLong) {
				 return null;
			 }

			 @Override
			 public <S extends Poll> List<S> findAll(Example<S> example) {
				 return null;
			 }

			 @Override
			 public <S extends Poll> List<S> findAll(Example<S> example, Sort sort) {
				 return null;
			 }

			 @Override
			 public <S extends Poll> List<S> saveAll(Iterable<S> entities) {
				 return null;
			 }

			 @Override
			 public List<Poll> findAllById(Iterable<Long> longs) {
				 return null;
			 }

			 @Override
			 public boolean existsById(Long aLong) {
				 return false;
			 }

			 @Override
			 public long count() {
				 return 0;
			 }

			 @Override
			 public void delete(Poll entity) {

			 }

			 @Override
			 public void deleteAllById(Iterable<? extends Long> longs) {

			 }

			 @Override
			 public void deleteAll(Iterable<? extends Poll> entities) {

			 }

			 @Override
			 public void deleteAll() {

			 }

			 @Override
			 public List<Poll> findAll(Sort sort) {
				 return null;
			 }

			 @Override
			 public Page<Poll> findAll(Pageable pageable) {
				 return null;
			 }

			 @Override
			 public <S extends Poll> Optional<S> findOne(Example<S> example) {
				 return Optional.empty();
			 }

			 @Override
			 public <S extends Poll> Page<S> findAll(Example<S> example, Pageable pageable) {
				 return null;
			 }

			 @Override
			 public <S extends Poll> long count(Example<S> example) {
				 return 0;
			 }

			 @Override
			 public <S extends Poll> boolean exists(Example<S> example) {
				 return false;
			 }

			 @Override
			 public <S extends Poll, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
				 return null;
			 }
		 };

		 final PollService pollService = new PollService(pollRepository);
		 PollController pc = new PollController(pollRepository,pollService);

		 pc.addPoll();

	}

	record NewPollRequest(
				String question
	){}

}
