import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.navigationdrawers.MessageAdapter
import com.example.navigationdrawers.com.example.navigationdrawers.Message
import com.example.tp5.R

class MessagesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_messages, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recycler = view.findViewById<RecyclerView>(R.id.recyclerMessages)
        recycler.layoutManager = LinearLayoutManager(requireContext())

        // Récupération des tableaux de strings
        val titles = resources.getStringArray(R.array.messages_title)
        val contents = resources.getStringArray(R.array.message_content)
        val dates = resources.getStringArray(R.array.message_dates)

        // Construction de la liste de messages
        val messagesList = mutableListOf<Message>()
        for (i in titles.indices) {
            messagesList.add(Message(titles[i], contents[i], dates[i]))
        }

        val adapter = MessageAdapter(messagesList)
        recycler.adapter = adapter
    }
}