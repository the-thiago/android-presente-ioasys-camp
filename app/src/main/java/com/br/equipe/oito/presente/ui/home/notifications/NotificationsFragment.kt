package com.br.equipe.oito.presente.ui.home.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import com.br.equipe.oito.presente.R
import com.br.equipe.oito.presente.databinding.FragmentNotificationsBinding
import com.br.equipe.oito.presente.model.Notification

class NotificationsFragment : Fragment() {

    private var _binding: FragmentNotificationsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setNotificationsRecycler()
    }

    private fun setNotificationsRecycler() {
        val mockedNotifications: MutableList<Notification> = fakeNotifications()
        binding.notificationRecycler.apply {
            setHasFixedSize(true)
            adapter = NotificationsAdapter(mockedNotifications)
            addItemDecoration(
                DividerItemDecoration(
                    requireContext(),
                    DividerItemDecoration.VERTICAL
                )
            )
        }
    }

    private fun fakeNotifications(): MutableList<Notification> {
        val notifications = mutableListOf<Notification>()
        repeat(10) {
            notifications.add(
                Notification(
                    image = R.drawable.ic_notification_image,
                    title = "Já leu isso aqui?",
                    description = "Pessoas com mesmos interesses que você adoram esse artigo, então trouxemos para você! \uD83E\uDD13"
                )
            )
        }
        return notifications
    }

}