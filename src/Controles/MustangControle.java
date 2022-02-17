package Controles;

import Entidades.Mustang;
import java.util.ArrayList;
import java.util.List;
import tools.ManipulaArquivo;

/**
 *
 * @author thamyris 01/11/2020 - 21:13:13
 */
public class MustangControle {

    private List<Mustang> lista = new ArrayList<>();

    public MustangControle() {
    }

    public void limparLista() {
        lista.clear();//zera a lista
    }

    public void adicionar(Mustang mustang) {
        lista.add(mustang);
    }

    public List<Mustang> listar() {
        return lista;
    }

    public Mustang buscar(int id) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getId() == id) {
                return lista.get(i);
            }
        }
        return null;
    }

    public void alterar(Mustang mustang, Mustang mustangAntigo) {
        lista.set(lista.indexOf(mustangAntigo), mustang);

    }

    public void excluir(Mustang mustang) {
        lista.remove(mustang);
    }

    public void gravarLista(String caminho) {
        ManipulaArquivo manipulaArquivo = new ManipulaArquivo();
        List<String> listaDeString = new ArrayList<>();
        for (Mustang mustang : lista) {
            listaDeString.add(mustang.toString() + System.lineSeparator());
        }
        manipulaArquivo.salvarArquivo(caminho, listaDeString);
    }

    public void carregarDados(String caminho) {
        ManipulaArquivo manipulaArquivo = new ManipulaArquivo();
        if (!manipulaArquivo.existeOArquivo(caminho)) {
            manipulaArquivo.criarArquivoVazio(caminho);
        }

        List<String> listaDeString = manipulaArquivo.abrirArquivo(caminho);
        //converter de CSV para Mustang
        Mustang mustang;
        for (String string : listaDeString) {
            String aux[] = string.split(";");
            mustang = new Mustang(Integer.valueOf(aux[0]), aux[1], aux[2]);
            lista.add(mustang);
        }
    }
} //fim da classe
