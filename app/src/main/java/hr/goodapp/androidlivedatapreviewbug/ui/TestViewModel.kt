package hr.goodapp.androidlivedatapreviewbug.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class TestViewModel : ViewModel() {

    fun bugWithPreview() = liveData<String> {
        delay(1000)
        val t = withContext(Dispatchers.Default) { "EDIT_THIS_FILED" } // Change value "EDIT_THIS_FILED" to some other value and preview will crash
        emit(t)
    }

}
