package io.github.AndCandido.Very.Useful.Tools.to.Remember.repositories;

import io.github.AndCandido.Very.Useful.Tools.to.Remember.models.Tool;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IToolRepository extends JpaRepository<Tool, Long> {

    @Query(value = "select * from TB_TOOLS where tags like %:tag%", nativeQuery = true)
    List<Tool> findToolByTag(@Param("tag") String tag);
}
