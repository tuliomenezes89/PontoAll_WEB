package dao;

import entidades.Funcionarios;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class FuncionariosDao {
    
    private Session sessao;
    private Transaction trans;
    
    public void addFuncionario(Funcionarios f){
        try{
            sessao = HibernateUtil.getSessionFactory().openSession();
            trans = sessao.beginTransaction();

            Funcionarios funcionario = new Funcionarios();
            funcionario.setNome(f.getNome());
            funcionario.setCargo(f.getCargo());
            funcionario.setDataNascimento(f.getDataNascimento());

            sessao.save(funcionario);
            trans.commit(); 

        }catch (Exception e){
            
            e.printStackTrace();
            
        }finally{
            sessao.close();
        }
    }
    
    public void removeFuncionario(Funcionarios f){
        
        try{
            sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();
        
        sessao.delete(f);
        trans.commit();
        
        }catch (Exception e){
            
            e.printStackTrace();
            
        }finally{
            sessao.close();
        }
        
    }
}
