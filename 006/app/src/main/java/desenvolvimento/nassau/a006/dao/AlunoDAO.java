package desenvolvimento.nassau.a006.dao;

import java.util.ArrayList;
import java.util.List;

import desenvolvimento.nassau.a006.model.Aluno;

/**
 * Created by paulo on 09/03/2017.
 */

public class AlunoDAO {
    public AlunoDAO() {
    }

    public List<Aluno> getAlunos(){
        int i=0;
        List<Aluno> alunos = new ArrayList<Aluno>();
        alunos.add(new Aluno(i++, "Alice", "alice@gmail.com"));
        alunos.add(new Aluno(i++, "Bob", "bob@gmail.com"));
        return alunos;
    }
}
