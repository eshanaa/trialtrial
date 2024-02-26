from django.dispatch import receiver

from apps.diaries.models import DiaryCommit
from apps.diaries.signals import diary_commit_created
from apps.xps.models import XP
from apps.diaries.services import calculate_diary_commit_xp


@receiver(diary_commit_created)
def increase_xp_by_diary_commit(
    sender,
    instance: DiaryCommit,
    **kwargs,
):
    total_xp_from_diary_commit = calculate_diary_commit_xp(instance)
    instance.diary.account.increase_xp(
        xp_amount=total_xp_from_diary_commit,
        xp_from=XP.EarnTypes.DIARY_COMMIT.value
    )
