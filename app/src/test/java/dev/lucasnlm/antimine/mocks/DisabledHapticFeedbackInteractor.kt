package dev.lucasnlm.antimine.mocks

import dev.lucasnlm.antimine.common.level.utils.IHapticFeedbackInteractor

class DisabledHapticFeedbackInteractor : IHapticFeedbackInteractor {
    override fun longPressFeedback() {
        // Empty
    }

    override fun explosionFeedback() {
        // Empty
    }
}
