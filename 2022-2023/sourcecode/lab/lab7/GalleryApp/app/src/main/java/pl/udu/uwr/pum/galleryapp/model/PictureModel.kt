package pl.udu.uwr.pum.galleryapp.model

data class PictureModel(val title: String, val image: String) {
    var id: Int = 0

    constructor(id: Int, title: String, image: String) : this(title, image) {
        this.id = id
    }
}