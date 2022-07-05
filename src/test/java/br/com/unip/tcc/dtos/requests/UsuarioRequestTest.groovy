package br.com.unip.tcc.dtos.requests

import spock.lang.Specification

import java.time.LocalDate
import java.time.Month

class UsuarioRequestTest extends Specification {

    def "should create an UsuarioRequest"() {
        given:
            def usuario = new UsuarioRequest(nome, email, senha, telefone, dataDeNacimento, descricao, urlImage)

        expect:
            nome == usuario.getNome()
            email == usuario.getEmail()
            descricao == usuario.getDescricao()
            senha == usuario.getSenha()
            telefone == usuario.getTelefone()
            dataDeNacimento == usuario.getDataDeNascimento()
            urlImage == usuario.getUrlImagem()

        where:
            nome   | email            | senha    | telefone         | dataDeNacimento                     | descricao              | urlImage
            "João" | "joao@gmail.com" | "123456" | "(61) 159753159" | LocalDate.of(1997, Month.APRIL, 12) | "Analista de Sistemas" | "url"
            "Ana"  | "ana@gmail.com"  | "321456" | "(61) 156378956" | LocalDate.of(1995, Month.APRIL, 12) | "Analista de Sistemas" | "url"

    }
}
