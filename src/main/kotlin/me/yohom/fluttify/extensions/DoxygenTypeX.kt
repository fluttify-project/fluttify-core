import me.yohom.fluttify.model.CompounddefType

fun CompounddefType.isView(): Boolean {
    return basecompoundref.firstOrNull()?.value == "android.view.View"
}