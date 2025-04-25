package com.khlebnikovevgeniy.securitycrudapi.model;

import static com.fasterxml.jackson.annotation.JsonProperty.Access.WRITE_ONLY;
import static jakarta.persistence.CascadeType.ALL;
import static jakarta.persistence.FetchType.EAGER;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "accounts")
public class Account {
	@Id
	private Long id;
	@Column(unique = true)
    @NotNull
	private String usermame;
	@JsonProperty(access = WRITE_ONLY)
    @NotNull
	private String password;
	private boolean enabled = true;
	private boolean credentialsexpired = false;
	private boolean expired = false;
	private boolean locked = false;
	@ManyToMany(fetch = EAGER, cascade = ALL)
	@JoinTable(
			name = "AccountRole",
            joinColumns = @JoinColumn(name = "accountId", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "roleId", referencedColumnName = "id")
			)
	private Set<Role> roles;
}
