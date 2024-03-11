package com.vit.assessment.presentation.features.match

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.vit.assessment.core.databinding.autoCleared
import com.vit.assessment.databinding.MatchFragmentBinding
import com.vit.assessment.presentation.features.match.adapter.MatchAdapter
import com.vit.assessment.presentation.features.team.adapter.TeamDecoration
import dagger.hilt.android.AndroidEntryPoint

/**
 * @author vietth
 * @since 09/03/2024
 */
@AndroidEntryPoint
class MatchFragment: Fragment() {
    private var binding by autoCleared<MatchFragmentBinding>()

    private var matchAdapter by autoCleared<MatchAdapter>()
    private val matchViewModel by viewModels<MatchViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MatchFragmentBinding.inflate(inflater, container, false)
        matchAdapter = MatchAdapter(requireContext())
        binding.rcvMatch.apply {
            adapter = matchAdapter
            addItemDecoration(TeamDecoration(context))
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        matchViewModel.fetchMatches()
        matchViewModel.matchesLiveData.observe(viewLifecycleOwner) {
            matchAdapter.submitList(it)
        }
    }
}