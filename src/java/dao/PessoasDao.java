package dao;

import entidades.Pessoas;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class PessoasDao {
    
    private Session sessao;
    private Transaction trans;
    private List<Pessoas> list;

    public List<Pessoas> getList() {
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();
        
        Criteria cri = sessao.createCriteria(Pessoas.class);
        this.list = cri.list();
        return list;
    }
    
    public void addPessoa(Pessoas p){
        try{
            sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();
        
        Pessoas pessoa = new Pessoas();
        pessoa.setNome(p.getNome());
        pessoa.setTelefone(p.getTelefone());
        pessoa.setEmail(p.getEmail());
        
        sessao.save(pessoa);
        trans.commit();
        
        } catch (Exception e){
            e.printStackTrace();            
        } 
        finally{
            sessao.close();
        }
    }   
    
    public void removePessoa (Pessoas p){
        
        try{
            sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();
        
        sessao.delete(p);
        trans.commit();
        
        } catch (Exception e){
            e.printStackTrace();            
        } 
        finally{
            sessao.close();
        }
    
    }
    
    public void updatePessoa (Pessoas p){
        
        try{
            sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();
        
        sessao.update(p);
        trans.commit();
        
        } catch (Exception e){
            e.printStackTrace();            
        } 
        finally{
            sessao.close();
        }
    
    }
}
