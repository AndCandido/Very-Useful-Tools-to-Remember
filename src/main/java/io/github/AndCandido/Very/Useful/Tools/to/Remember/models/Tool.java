package io.github.AndCandido.Very.Useful.Tools.to.Remember.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "TB_TOOLS")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Tool {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String link;
    private String description;
    private List<String> tags;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
