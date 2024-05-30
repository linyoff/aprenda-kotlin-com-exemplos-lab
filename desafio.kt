enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario(val nome: String)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, val nivel: Nivel, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
        println("Usuário ${usuario.nome} matriculado com sucesso na formação $nome.")
    }
}

fun main() {
    // Criação de alguns conteúdos educacionais
    val conteudoKotlin = ConteudoEducacional("Introdução ao Kotlin")
    val conteudoJava = ConteudoEducacional("Programação com Java", 90)
    val conteudoWeb = ConteudoEducacional("Desenvolvimento Web", 120)

    // Criação de uma formação
    val formacaoAndroid = Formacao(
        nome = "Formação Android Developer",
        nivel = Nivel.INTERMEDIARIO,
        conteudos = listOf(conteudoKotlin, conteudoJava, conteudoWeb)
    )

    // Criação de usuários
    val usuario1 = Usuario("Aliny")
    val usuario2 = Usuario("Washington")

    // Matricular usuários na formação
    formacaoAndroid.matricular(usuario1)
    formacaoAndroid.matricular(usuario2)

    // Exibir informações da formação
    println("Formação: ${formacaoAndroid.nome}")
    println("Nível: ${formacaoAndroid.nivel}")
    println("Conteúdos: ${formacaoAndroid.conteudos.joinToString { it.nome }}")
    println("Inscritos: ${formacaoAndroid.inscritos.joinToString { it.nome }}")
}

