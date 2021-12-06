from datetime import datetime, timedelta
import discord
from discord.ext import commands
from apscheduler.schedulers.asyncio import AsyncIOScheduler
from apscheduler.triggers.cron import CronTrigger
from apscheduler.triggers.date import DateTrigger
from discord import PCMAudio, FFmpegOpusAudio
import ctypes.util
import opuslib.api


bot = commands.Bot(command_prefix = "!")

scheduler = AsyncIOScheduler()
# discord.opus.load_opus(ctypes.util.find_library('opus'))


async def uldyahr_timer():
    channel = bot.get_channel(911915154986393630)
    print('울디아르 타이머 실행.')
    embed = discord.Embed(title = '`!울디아르 출현!`', color = 0x00ff56)
    embed.add_field(name = '**글루디오 던전 4층**', value = '울디아르가 10분 뒤에 출현합니다.')
    embed.set_footer(text = f'현재 시각 : {datetime.now()}')
    await channel.send(embed = embed)


async def ghast_timer():
    channel = bot.get_channel(911915154986393630)
    print('가스트 타이머 실행.')
    embed = discord.Embed(title = '`!가스트 로드 출현!`', color = 0x00ff56)
    embed.add_field(name = '**죽음의 숲**', value = '가스트 로드가 10분 뒤에 출현합니다.')
    embed.set_footer(text = f'현재 시각 : {datetime.now()}')
    await channel.send(embed = embed)


async def kardish_timer():
    channel = bot.get_channel(911915154986393630)
    print('카르디쉬 타이머 실행.')
    embed = discord.Embed(title = '`!카르디쉬 출현!`', color = 0x00ff56)
    embed.add_field(name = '**윈다우드 성 오른쪽 사막**', value = '카르디쉬가 10분 뒤에 출현합니다.')
    embed.set_footer(text = f'현재 시각 : {datetime.now()}')
    await channel.send(embed = embed)


async def slaughterer_timer():
    channel = bot.get_channel(911915154986393630)
    print('도살자 타이머 실행.')
    embed = discord.Embed(title = '`!도살자 출현!`', color = 0x00ff56)
    embed.add_field(name = '**죽음의 폐허**', value = '도살자가 10분 뒤에 출현합니다.')
    embed.set_footer(text = f'현재 시각 : {datetime.now()}')
    await channel.send(embed = embed)


async def kaspa_timer():
    channel = bot.get_channel(911915154986393630)
    # guild = bot.get_guild(911226114519760946)
    # voice_client = discord.utils.get(bot.voice_clients, guild = guild)
    # audio_source = FFmpegOpusAudio('kaspa-tts.mp3')
    print('카스파 타이머 실행.')
    embed = discord.Embed(title = '`!카스파 출현!`', color = 0x00ff56)
    embed.add_field(name = '**글루디오 던전 3층 or 4층**', value = '카스파가 곧 출현합니다.')
    embed.set_footer(text = f'현재 시각 : {datetime.now()}')
    await channel.send(embed = embed)
    # voice_client.play(audio_source, after = None)


@bot.event
async def on_ready():
    game = discord.Game('문의 @로란 | !명령어')

    # voice_channel = bot.get_channel(911913502891987024)

    await bot.change_presence(status = discord.Status.dnd, activity = game)

    scheduler.add_job(uldyahr_timer, CronTrigger(minute = '5', hour = '0/2'))
    scheduler.add_job(ghast_timer, CronTrigger(minute = '35', hour = '1/2'))
    scheduler.add_job(kardish_timer, CronTrigger(minute = '35', hour = '0/2'))
    scheduler.add_job(slaughterer_timer, CronTrigger(hour = '1/3'))
    scheduler.start()

    # await voice_channel.connect()

    print('--- 봇 실행 중 ---')


# @bot.command(name = 'help')
# async def bot_help(ctx):
#     pass


@bot.command(name = '보스')
async def boss(ctx, *args):
    channel = bot.get_channel(911912677041901588)
    if not ctx.channel == channel:
        embed = discord.Embed(color = 0xCD1039)
        embed.set_author(name = f'{channel} 채널에 명령어를 입력해주세요.')
        await ctx.send(embed = embed)

    else:
        list_ = list(args)
        if not 0 < len(list_) and len(list_) <= 2:
            embed = discord.Embed(color = 0xCD1039)
            embed.add_field(name = '**명령어를 잘못 입력하였습니다!**', value = '명령어를 다시 확인해주세요.')
            await ctx.send(embed = embed)

        else:
            if list_[0] == '목록':
                embed = discord.Embed(title = '등록된 보스 목록', color = 0x7B68EE)
                embed.add_field(name = '__**고정 젠 보스 **__', value = '`도살자`, `카르디쉬`, `울디아르`, `가스트 로드`', inline = False)
                embed.add_field(name = '__**컷 기준 젠 보스**__', value = '`카스파`', inline = False)
                embed.set_footer(text = '@개발자 : 로란')
                await ctx.send(embed = embed)

            elif list_[0] == '컷':
                if list_[1] == '카스파':
                    # run_date = datetime.now() + timedelta(seconds = 10)
                    run_date = datetime.now() + timedelta(hours = 5, minutes = 50)
                    date_trigger = DateTrigger(run_date = run_date, timezone = 'Asia/Seoul')
                    flag = True
                    for item in scheduler.get_jobs():
                        if item.name == 'kaspa_timer':
                            flag = False

                    if flag:
                        scheduler.add_job(kaspa_timer, date_trigger)

                        embed = discord.Embed(title = '`!카스파 처치!`', color = 0x00ff56)
                        embed.add_field(name = '**카스파의 처치를 확인하였습니다.**', value = '타이머를 작동합니다.')

                        await ctx.send(embed = embed)
                    else:
                        embed = discord.Embed(color = 0xCD1039)
                        embed.set_author(name = '**카스파 타이머가 이미 작동 중입니다!**')
                        await ctx.send(embed = embed)

                else:
                    embed = discord.Embed(color = 0xCD1039)
                    embed.set_author(name = '**등록되지 않은 보스입니다.**')
                    await ctx.send(embed = embed)

            else:
                embed = discord.Embed(color = 0xCD1039)
                embed.add_field(name = '**명령어를 잘못 입력하였습니다!**', value = '명령어를 다시 확인해주세요.')
                await ctx.send(embed = embed)


@bot.command(name = '명령어')
async def command_help(ctx):
    channel = bot.get_channel(911912677041901588)
    embed = discord.Embed(title = '리니지 보스 알리미 사용법', color = 0x7B68EE)
    embed.set_author(name = 'BOT의 명령어는 여기서 입력 가능 합니다.')
    embed.add_field(name = '**!보스 [   ]**', value = '*보스 관련 명령어*', inline = False)
    embed.add_field(name = '`!보스 목록`', value = '__BOT에 등록된 보스 목록을 보여줍니다.__', inline = True)
    embed.add_field(name = '`!보스 컷 [보스 이름]`', value = '__입력한 보스의 타이머를 시작합니다.\n컷 기준 젠 보스만 사용 가능합니다.__', inline = True)
    embed.add_field(name = '`!보스 일정`', value = '__가장 빠른 보스 일정 5개를 보여줍니다.__', inline = False)
    embed.add_field(name = '**추가 예정**', value = '*요구사항 말씀 주시면 추가해볼게요.*', inline = False)
    embed.set_footer(text = '@개발자 : 로란')

    await channel.send(embed = embed)


@bot.event
async def on_command_error(ctx, error):
    channel = bot.get_channel(911912677041901588)
    if not ctx.channel == channel:
        embed = discord.Embed(color = 0xCD1039)
        embed.set_author(name = f'{channel} 채널에 명령어를 입력해주세요.')
        await ctx.send(embed = embed)
    else:
        if isinstance(error, commands.CommandNotFound):
            embed = discord.Embed(color = 0xCD1039)
            embed.set_author(name = '해당 명령어를 찾지 못하였습니다!')
            await ctx.send(embed = embed)


bot.run('OTExNjI0Mjk3MDQ5NjI0NjE3.YZkGSQ.MXZP6dhqB55r30VKxLWLiE2go28')
