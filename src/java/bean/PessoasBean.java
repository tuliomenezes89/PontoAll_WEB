package bean;

import dao.PessoasDao;
import entidades.Pessoas;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.faces.bean.ManagedBean;

@Named(value = "pessoasBean")
@ManagedBean
@SessionScoped
public class PessoasBean implements Serializable {

    private Pessoas pessoa = new Pessoas();
    private PessoasDao pessoaDao = new PessoasDao();
    private List<Pessoas> listaPessoas;
    
    
    public PessoasBean() {
    }
    
    public String adicionarPessoa(){
        pessoaDao.addPessoa(pessoa);
        pessoa.setNome(null);
        pessoa.setEmail(null);
        pessoa.setTelefone(null);
        return "index";
}
    
    public List listarPessoas(){
        listaPessoas = pessoaDao.getList();
        return this.listaPessoas;
    }
    
    public String removePessoa(Pessoas p){
        pessoa = p;
        pessoaDao.removePessoa(this.pessoa);
        this.pessoa.setNome(null);
        this.pessoa.setEmail(null);
        this.pessoa.setTelefone(null);
        return "index";
}
    
    public String carregarPessoas(Pessoas p){
        pessoa = p;
        return "editar";
    }
    
    public String atualizarPessoas(){
        pessoaDao.updatePessoa(pessoa);
        pessoa.setNome(null);
        pessoa.setEmail(null);
        pessoa.setTelefone(null);
        return "index";
    }
    

    public Pessoas getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoas pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.pessoa);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PessoasBean other = (PessoasBean) obj;
        if (!Objects.equals(this.pessoa, other.pessoa)) {
            return false;
        }
        return true;
    }
    
    
    
}
