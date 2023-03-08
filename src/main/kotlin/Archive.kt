import java.util.*


class Repository{

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

            var choice : String = scan.next()
            var choiceInt : Int = 0

            try {
                choiceInt = choice.toInt()
            } catch (e: Exception){

                println("Введите цифру для выбора пункта меню.")
                continue
            }

            when (choiceInt) {

                (0) -> break
                (1) -> {
                    val archive = selectArchive()
                    archive?.processingNotes()
                }
                (2) -> {
                    val archive = createArchive()
                    archive?.processingNotes()
                }
                else -> println("Выберите цифру, соответствующую пункту меню")

            }

        }
    }

    fun createArchive() : Archive {

        println("Введите имя нового архива: ")
        val name = scan.next()

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

            var choice:String = scan.next()
            var choiceInt:Int = 0

            try {
                choiceInt = choice.toInt()
            } catch (e: Exception){

                println("Введите цифру для выбора пункта меню.")
                continue
            }

            when (choiceInt) {

                (0) -> break

                else -> {

                    try {
                        selectedArchive = listOfArchives.get(choiceInt - 1)
                    } catch (e: Exception){
                        println("Введите цифру архива для выбора или 0 для выхода.")
                        continue
                    }

                    if (selectedArchive == null) {
                        println("Введите цифру архива для выбора или 0 для выхода.")
                        continue
                    }

                }

            }   // when (choice)
        }

        return selectedArchive
    }

}

class Archive(val name: String) {

    var scan = Scanner(System.`in`)

    var listOfNotes: MutableList<Note> = mutableListOf<Note>()

    class Note(val content: String) {
    }

    fun processingNotes(){

        while (true){

            println("------------------------------------------")
            println("* Работа с заметками архива - $name *")
            println("------------------------------------------")

            println("0 - Выход")
            println("1 - Выбрать заметку")
            println("2 - Добавить заметку")

            var choice:String = scan.next()
            var choiceInt:Int = 0

            try {
                choiceInt = choice.toInt()
            } catch (e: Exception){

                println("Введите цифру для выбора пункта меню.")
                continue
            }

            when (choiceInt){

                (0) -> break
                (1) -> selectNote()
                (2) -> addNote()
                else -> println("Введите цифру напротив действия")

            }

        }

    }

    fun addNote(){

        println("Введите новую заметку: ")
        val content = scan.next()

        listOfNotes.add(Note(content))
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
                println("$i - ${item.content}")
                        i = i + 1
            }

            println("0 - Выход")

            var choice:String = scan.next()
            var choiceInt:Int = 0

            try {
                choiceInt = choice.toInt()
            } catch (e: Exception){

                println("Введите цифру для выбора пункта меню.")
                continue
            }

            when (choiceInt){

                (0) -> break

                else -> {

                    var selectedNote: Note? = null

                    try {
                        selectedNote = this.listOfNotes.get(choiceInt - 1)
                    } catch (e: Exception){
                        println("Введите номер заметки для выбора или 0 для выхода.")
                        continue
                    }

                    if (selectedNote == null){
                        println("Введите номер заметки для выбора или 0 для выхода.")
                        continue
                    }

                    println("Просмотр заметки:  ${selectedNote.content}")

                }

            }

        }

    }

}
