package com.example.demo.controllers

import com.example.demo.entities.Country
import com.example.demo.repositories.CountryRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import javax.persistence.EntityNotFoundException
import javax.validation.Valid

@RestController
@RequestMapping("/countries")
class CountryController {
    @Autowired
    lateinit var repository: CountryRepository

    @GetMapping
    fun getAllCountries(): List<Country>{
        return repository.findAll()
    }

    @PostMapping
    fun create(@Valid @RequestBody country: Country): Country{
        return repository.save(country)
    }

    @GetMapping("/{id}")
    fun show(@PathVariable("id") id: Long) : Country{
        return repository.findById(id).orElseThrow{ EntityNotFoundException() }
    }

    @PutMapping("/{id}")
    fun update(@Valid @PathVariable("id") id : Long, @RequestBody newCountry: Country) : Country{
        val country = repository.findById(id).orElseThrow{ EntityNotFoundException() }

        country.apply {
            this.nome = newCountry.nome
            this.capital = newCountry.capital
            this.regiao = newCountry.regiao
        }

        return repository.save(country)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") id: Long){
        val country = repository.findById(id).orElseThrow{ EntityNotFoundException() }
        repository.delete(country)
    }
}