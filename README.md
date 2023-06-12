# Generics

Generics é uma funcionalidade introduzida na versão 5 do Java. O seu objetivo é fornecer ao desenvolvedor a capacidade de escrever código que seja reutilizavel e, ao mesmo tempo, com a segurança da verificação de tipos em tempo de compilação. As *APIs* da própria linguagem utilizam largamente estas funcionalidades, como é o caso das conhecidas interfaces *List* e *Map* por exemplo.

O Generics é delimitado pelos caracteres ``<>``, ou seja, quando houver esse par de caracteres em uma parte qualquer do código, significa que o Generics está sendo utilizado.

- *Exemplo*
  ``List<String> listaDeString = new ArrayList<String>();``

Generics também provê em tempo de compilação uma verificação de *type-safety de código*, removendo riscos de ClassCastException durante a execução, o qual era um erro comum antes da versão 1.5.
Essa verificação consiste em verificar se o que está sendo atribuído a uma instância de uma classe está de acordo com o especificado

- *Exemplo*
  // Antes do Java 1.5
  List palavras = new ArrayList();
  palavras.add("ABC"); //Tudo ok, compatível com o especificado
  palavras.add(12); //Erro de ClassCastException em tempo de execução

// Após o Java 1.5
List<String> palavras = new ArrayList<String>();
palavras.add("ABC"); //Tudo ok, compatível com o especificado
palavras.add(12); //Erro de compilação

## Onde são utilizados os Generics

- Generics em Classes e Interfaces
    ``public interface List<T>extends Collection<T>{...}``

- Generics em Métodos
    ``public <T> void getFirst(List<T>list) {...}``

- Generics em Construtores
    ``public class Generics.GenericEntry<T> {
        private T data;
        private int rank;
    }``

    ``public Generics.GenericEntry(T data, int rank) {
        this.data = data;
        this.rank = rank;
    }``

### Wildcards

Existem 3 tipos de Wildcards em Generics:

- *Uknown Wildcard*, ou seja, Wildcard desconhecido
    - <?>
- *Extends Wildcard*
    - <? extends XXX>
- Super Wildcards
    - <? super XXX>