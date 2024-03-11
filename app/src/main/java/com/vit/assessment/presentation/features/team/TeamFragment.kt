package com.vit.assessment.presentation.features.team

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.vit.assessment.core.databinding.autoCleared
import com.vit.assessment.databinding.TeamFragmentBinding
import com.vit.assessment.presentation.features.team.adapter.TeamAdapter
import com.vit.assessment.presentation.features.team.adapter.TeamDecoration
import dagger.hilt.android.AndroidEntryPoint

/**
 * @author vietth
 * @since 09/03/2024
 */
@AndroidEntryPoint
class TeamFragment: Fragment() {
    private var binding by autoCleared<TeamFragmentBinding>()

    private var teamAdapter by autoCleared<TeamAdapter>()
    private val teamViewModel by viewModels<TeamViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = TeamFragmentBinding.inflate(inflater, container, false)
        teamAdapter = TeamAdapter(requireContext())
        binding.rcvTeam.apply {
            adapter = teamAdapter
            addItemDecoration(TeamDecoration(context))
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        teamViewModel.fetchTeams()
        teamViewModel.teamsLiveData.observe(viewLifecycleOwner) {
            teamAdapter.submitList(it)
        }
    }

}