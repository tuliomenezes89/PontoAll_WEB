package bean;

import dao.FuncionariosDao;
import entidades.Funcionarios;
import java.util.Objects;
import javax.inject.Named;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@Named(value = "funcionariosBean")
@ManagedBean
@SessionScoped
public class FuncionariosBean {

    private Funcionarios funcionario = new Funcionarios();
    private FuncionariosDao funcionarioDao = new FuncionariosDao();
    
    public FuncionariosBean() {
    }
    
    public String adicionarFuncionario(){
        funcionarioDao.addFuncionario(funcionario);
        funcionario.setNome(null);
        funcionario.setCargo(null);
        funcionario.setDataNascimento(null);
        return "index";
    }
    
    public String removerFuncionario(){
        funcionarioDao.removeFuncionario(funcionario);
        return "sucessoRemove";
    }
    

    public Funcionarios getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionarios funcionario) {
        this.funcionario = funcionario;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.funcionario);
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
        final FuncionariosBean other = (FuncionariosBean) obj;
        if (!Objects.equals(this.funcionario, other.funcionario)) {
            return false;
        }
        return true;
    }
    
    
}
