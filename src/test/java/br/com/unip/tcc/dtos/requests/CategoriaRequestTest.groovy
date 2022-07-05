package br.com.unip.tcc.dtos.requests

import spock.lang.Specification

class CategoriaRequestTest extends Specification {

    def "should create an CategoriaRequest"() {
        given:
            def categoria = new CategoriaRequest(nome, descricao)

        expect:
            nome == categoria.getNome()
            descricao == categoria.getDescricao()

        where:
            nome          | descricao
            "Informatica" | "Informatica"
            "Web"         | "World Wide Web"

    }
}
