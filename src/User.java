public class User {
    public int id;
    public String name;
    public String email;
    public String senha;
    public float saldo;

    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getSenha() {return senha;}
    public void setSenha(String senha) {this.senha = senha;}

    public float getSaldo(){return saldo;}
    public void setSaldo(float saldo ){this.saldo = saldo; }
}

