package repositories;

import java.util.List;

/**
 *
 * @author Leszek Karwacki<s7918@pjwstk.edu.pl>
 * @param <TEntity>
 */
public interface IRepository<TEntity> {
    public void add(TEntity entity);
    public void update(TEntity entity);
    public void delete(TEntity entity);
    public TEntity get(String mail);
    public List<TEntity> getAll();
}