import java.util.*

class Archive(val name: String) {

    var scan = Scanner(System.`in`)
    var listOfNotes: MutableList<String> = mutableListOf<String>()

    fun processingNotes() {

        while (true) {

            println("------------------------------------------")
            println("* Работа с заметками архива - $name *")
            println("------------------------------------------")

            println("0 - Выход")
            println("1 - Выбрать заметку")
            println("2 - Добавить заметку")

            when (choiceInt()) {
                (null) -> continue
                (0) -> break
                (1) -> selectNote()
                (2) -> addNote()
                else -> println("Введите цифру для выбора пункта меню")
            }
        }
    }

    fun addNote() {
        println("Введите новую заметку: ")
        val content = scan.nextLine()
        listOfNotes.add(content)
        println("новая заметка добавлена - $content")
    }

    fun selectNote(){

        if (listOfNotes.isEmpty()){
            println("В архиве ${this.name} нет заметок для выбора, добавьте новую.")
            return
        }

        while (true){

            println("----------------------------------")
            println("* Выберите заметку для просмотра *")
            println("----------------------------------")

            var i = 1

            for (item in this.listOfNotes) {
                println("$i - $item")
                i = i + 1
            }

            println("0 - Выход")

            val choiceInt = choiceInt()
            when (choiceInt){
                (null) -> continue
                (0) -> break
                else -> {

                    var selectedNote: String?

                    try {
                        selectedNote = this.listOfNotes.get(choiceInt-1)
                    } catch (e: Exception){
                        println("Введите номер заметки для выбора или 0 для выхода.")
                        continue
                    }

                    println("Просмотр заметки:  $selectedNote")
                }
            }
        }
    }
}

fun choiceInt():Int?{
    val scan = Scanner(System.`in`)
    val choice:String = scan.next()

    try {
        return choice.toInt()
    } catch (e: Exception){
        println("Введите цифру для выбора пункта меню.")
        return null
    }
}

