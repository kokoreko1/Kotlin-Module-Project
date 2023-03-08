import java.util.*

class Repository {

    val scan = Scanner(System.`in`)
    var listOfArchives: MutableList<Archive> = mutableListOf<Archive>()

    fun processingArchives(){

        while (true) {

            println("--------------------------------")
            println("* Выберите действие с архивами *")
            println("--------------------------------")

            println("0 - Выход")
            println("1 - Выбрать архив")
            println("2 - Создать новый архив")

            when (choiceInt()) {
                (null) -> continue
                (0) -> break
                (1) -> selectArchive()?.processingNotes()
                (2) -> createArchive().processingNotes()
                else -> println("Выберите цифру, соответствующую пункту меню")
            }
        }
    }

    fun createArchive() : Archive {
        println("Введите имя нового архива: ")
        val name = scan.nextLine()
        val newArchive = Archive(name)
        listOfArchives.add(newArchive)
        println("Архив добавлен - $name")
        return newArchive
    }

    fun selectArchive() : Archive? {

        var selectedArchive: Archive? = null

        if (listOfArchives.isEmpty()) {
            println("Архивов для выбора нет, добавьте новый.")
            return null
        }

        while (true) {

            println("------------------")
            println("* Выберите архив *")
            println("------------------")

            var i = 1

            for (item in listOfArchives) {
                println("$i - ${item.name}")
                i = i + 1
            }

            println("0 - Выход")

            val choiceInt = choiceInt()

            when (choiceInt) {
                (null) -> continue
                (0) -> break
                else -> {
                    try {
                        selectedArchive = listOfArchives.get(choiceInt-1)
                        break
                    } catch (e: Exception){
                        println("Введите цифру архива для выбора или 0 для выхода.")
                        continue
                    }
                }
            }
        }
        return selectedArchive
    }
}